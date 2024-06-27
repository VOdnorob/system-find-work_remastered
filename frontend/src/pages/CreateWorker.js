import React, { useState } from 'react';
import ApiService from '../services/ApiService';

const CreateWorker = () => {
    const [worker, setWorker] = useState({
        name: '',
        surname: '',
        email: '',
        password: '',
        age: '',
        phoneNumber: '',
        nationality: '',
        city: '',
        street: '',
        houseNumber: '',
        pesel: '',
        // інші поля
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setWorker((prevWorker) => ({
            ...prevWorker,
            [name]: value,
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        ApiService.createWorker(worker)
            .then(response => {
                console.log('Worker created successfully', response);
                // Обробка успішного створення
            })
            .catch(error => {
                console.error('There was an error creating the worker!', error);
            });
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Name:</label>
                <input type="text" name="name" value={worker.name} onChange={handleChange} required />
            </div>
            <div>
                <label>Surname:</label>
                <input type="text" name="surname" value={worker.surname} onChange={handleChange} required />
            </div>
            <div>
                <label>Email:</label>
                <input type="email" name="email" value={worker.email} onChange={handleChange} required />
            </div>
            <div>
                <label>Password:</label>
                <input type="password" name="password" value={worker.password} onChange={handleChange} required />
            </div>
            <div>
                <label>Age:</label>
                <input type="number" name="age" value={worker.age} onChange={handleChange} required />
            </div>
            <div>
                <label>Phone Number:</label>
                <input type="text" name="phoneNumber" value={worker.phoneNumber} onChange={handleChange} required />
            </div>
            <div>
                <label>Nationality:</label>
                <input type="text" name="nationality" value={worker.nationality} onChange={handleChange} required />
            </div>
            <div>
                <label>City:</label>
                <input type="text" name="city" value={worker.city} onChange={handleChange} required />
            </div>
            <div>
                <label>Street:</label>
                <input type="text" name="street" value={worker.street} onChange={handleChange} required />
            </div>
            <div>
                <label>House Number:</label>
                <input type="text" name="houseNumber" value={worker.houseNumber} onChange={handleChange} required />
            </div>
            <div>
                <label>PESEL:</label>
                <input type="text" name="pesel" value={worker.pesel} onChange={handleChange} required />
            </div>
            <button type="submit">Create Worker</button>
        </form>
    );
};

export default CreateWorker;