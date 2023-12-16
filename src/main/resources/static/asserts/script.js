// Selecting form and input elements
const form = document.querySelector("form");
const passwordInput = document.getElementById("password");
const passToggleBtn = document.getElementById("pass-toggle-btn");

// Function to display error messages
const showError = (field, errorText) => {
  field.classList.add("error");
  const errorElement = document.createElement("small");
  errorElement.classList.add("error-text");
  errorElement.innerText = errorText;
  field.closest(".form-group").appendChild(errorElement);
};

// Function to remove error messages
const clearError = (field) => {
  field.classList.remove("error");
  const errorText = field.closest(".form-group").querySelector(".error-text");
  if (errorText) {
    errorText.remove();
  }
};

// Function to validate email format
const validateEmail = (email) => {
  const emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
  return emailPattern.test(email);
};

// Function to handle form submission
const handleFormData = (e) => {
  e.preventDefault();

  // Retrieving input elements
  const fullnameInput = document.getElementById("fullname");
  const dateInput = document.getElementById("date");
  const studentidInput = document.getElementById("studentid");
  const passwordInput = document.getElementById("password");


  // Getting trimmed values from input fields
  const fullname = fullnameInput.value.trim();
  const password = passwordInput.value.trim();
  const date = dateInput.value;
  const studentid = studentidInput.value.trim();

  // Clearing previous error messages
  document.querySelectorAll(".form-group .error").forEach(clearError);

  // Performing validation checks
  if (fullname === "") {
    showError(fullnameInput, "*Enter your full name");
  }
  if (password === "") {
    showError(passwordInput, "*Enter your password");
  }
  if (date === "") {
    showError(dateInput, "*Select your date of birth");
  }
  if (studentid === "") {
    showError(studentidInput, "*Enter your student id");
  }

  // Checking for any remaining errors before form submission
  const errorInputs = document.querySelectorAll(".form-group .error");
  if (errorInputs.length === 0) {
    // Submitting the form if there are no errors
    form.submit();
  }
};

// Toggling password visibility
passToggleBtn.addEventListener("click", () => {
  passToggleBtn.classList.toggle("fa-eye");
  passToggleBtn.classList.toggle("fa-eye-slash");
  passwordInput.type =
    passwordInput.type === "password" ? "text" : "password";
});

// Handling form submission event
form.addEventListener("submit", handleFormData);
