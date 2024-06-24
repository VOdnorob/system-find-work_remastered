import React, { useState } from 'react';
import axios from 'axios';

const EmployerRegistration = () => {
    const [employer, setEmployer] = useState({
        // заповніть властивостями з класу Employer
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setEmployer({ ...employer, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/employers', employer)
            .then(response => {
                console.log(response.data);
            })
            .catch(error => {
                console.error(error);
            });
    };

    return (
        <form onSubmit={handleSubmit}>
            <h1>Employer Registration</h1>
            {/* Поля форми для employer */}
            <button type="submit">Register</button>
        </form>
    );
};

export default EmployerRegistration;