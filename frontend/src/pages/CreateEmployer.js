import React, { useState } from 'react';
import ApiService from '../services/ApiService';

const CreateEmployer = () => {
    const [employer, setEmployer] = useState({
        name: '',
        email: '',
        password: '',
        // інші поля
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setEmployer((prevEmployer) => ({
            ...prevEmployer,
            [name]: value,
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        ApiService.createEmployer(employer)
            .then(response => {
                console.log('Employer created successfully', response);
                // Обробка успішного створення
            })
            .catch(error => {
                console.error('There was an error creating the employer!', error);
            });
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Name:</label>
                <input type="text" name="name" value={employer.name} onChange={handleChange} required />
            </div>
            <div>
                <label>Email:</label>
                <input type="email" name="email" value={employer.email} onChange={handleChange} required />
            </div>
            <div>
                <label>Password:</label>
                <input type="password" name="password" value={employer.password} onChange={handleChange} required />
            </div>
            <button type="submit">Create Employer</button>
        </form>
    );
};

export default CreateEmployer;