
// Funciones comunes y validaciones para el proyecto

function validateForm(formId) {
    const form = document.getElementById(formId);
    form.addEventListener('submit', function(event) {
        const nameInput = form.querySelector('input[type="text"]');
        const emailInput = form.querySelector('input[type="email"]');
        let valid = true;

        if (!/^[a-zA-Z\s]+$/.test(nameInput.value.trim())) {
            valid = false;
            alert('El nombre solo debe contener letras.');
        }

        if (emailInput && !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(emailInput.value.trim())) {
            valid = false;
            alert('El formato del correo electrónico es incorrecto.');
        }

        if (!valid) {
            event.preventDefault();  // Evitar el envío si hay errores
        }
    });
}
