import React, { useState } from 'react';
import axios from 'axios';

const EmployerRegistration = () => {
    const [employer, setEmployer] = useState({
        name: '',
        address: '',
        contactNumber: '',
        email: '',
        password: ''
        // інші властивості, якщо необхідно
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setEmployer({ ...employer, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/employers/createEmployer', employer)
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
            <label>
                Name:
                <input type="text" name="name" value={employer.name} onChange={handleChange} />
            </label>
            <label>
                Address:
                <input type="text" name="address" value={employer.address} onChange={handleChange} />
            </label>
            <label>
                Contact Number:
                <input type="text" name="contactNumber" value={employer.contactNumber} onChange={handleChange} />
            </label>
            <label>
                Email:
                <input type="email" name="email" value={employer.email} onChange={handleChange} />
            </label>
            <label>
                Password:
                <input type="password" name="password" value={employer.password} onChange={handleChange} />
            </label>
            {/* Додайте інші поля за необхідності */}
            <button type="submit">Register</button>
        </form>
    );
};

export default EmployerRegistration;