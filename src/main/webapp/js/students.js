
document.addEventListener('DOMContentLoaded', function() {
    const searchInput = document.getElementById('search-student');
    const tableBody = document.getElementById('students-table-body');
    const pagination = document.querySelector('.pagination');

    function fetchStudents() {
        return [
            { id: 1, name: 'Juan Pérez' },
            { id: 2, name: 'Ana Gómez' },
            { id: 3, name: 'Pedro Martínez' },
            { id: 4, name: 'Laura Fernández' },
            { id: 5, name: 'Carlos López' }
        ];
    }

    function renderStudents(students) {
        tableBody.innerHTML = students.map(student => `
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>
                    <a href="edit-student.html?id=${student.id}" class="btn btn-warning btn-sm">Editar</a>
                    <button class="btn btn-danger btn-sm" onclick="deleteStudent(${student.id})">Eliminar</button>
                </td>
            </tr>
        `).join('');
    }

    function handleSearch() {
        const query = searchInput.value.toLowerCase();
        const students = fetchStudents();
        const filtered = students.filter(student => student.name.toLowerCase().includes(query));
        renderStudents(filtered);
    }

    searchInput.addEventListener('input', handleSearch);
    renderStudents(fetchStudents());
});

function deleteStudent(id) {
    if (confirm('¿Estás seguro de que deseas eliminar este estudiante?')) {
        // Lógica para eliminar el estudiante
    }
}

