
// Funciones comunes y validaciones para el proyecto

function validateForm(formId) {
    const form = document.getElementById(formId);
    form.addEventListener('submit', function(event) {
        const nameInput = form.querySelector('input[type="text"]');
        if (!nameInput.value.trim()) {
            alert('El nombre es obligatorio.');
            event.preventDefault();
        }
    });
}
