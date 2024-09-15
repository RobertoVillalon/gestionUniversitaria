
document.addEventListener('DOMContentLoaded', function() {
    const searchInput = document.getElementById('search-course');
    const tableBody = document.getElementById('courses-table-body');
    const pagination = document.querySelector('.pagination');

    function fetchCourses() {
        return [
            { id: 1, name: 'Matemáticas' },
            { id: 2, name: 'Historia' },
            { id: 3, name: 'Física' },
            { id: 4, name: 'Biología' },
            { id: 5, name: 'Química' }
        ];
    }

    function renderCourses(courses) {
        tableBody.innerHTML = courses.map(course => `
            <tr>
                <td>${course.id}</td>
                <td>${course.name}</td>
                <td>
                    <a href="edit-course.html?id=${course.id}" class="btn btn-warning btn-sm">Editar</a>
                    <button class="btn btn-danger btn-sm" onclick="deleteCourse(${course.id})">Eliminar</button>
                </td>
            </tr>
        `).join('');
    }

    function handleSearch() {
        const query = searchInput.value.toLowerCase();
        const courses = fetchCourses();
        const filtered = courses.filter(course => course.name.toLowerCase().includes(query));
        renderCourses(filtered);
    }

    searchInput.addEventListener('input', handleSearch);
    renderCourses(fetchCourses());
});

function deleteCourse(id) {
    if (confirm('¿Estás seguro de que deseas eliminar este curso?')) {
        // Lógica para eliminar el curso
    }
}
