import React, { useState } from 'react';
import { createWorker } from '../services/workerService';

function CreateWorkerForm() {
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
        pesel: ''
    });

    // Для відображення повідомлення про помилку
    const [error, setError] = useState('');

    const handleChange = (e) => {
        const { name, value } = e.target;
        setWorker(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError(''); // Очищення попередньої помилки
        try {
            const response = await createWorker(worker);
            alert('Worker created successfully!');
            // Очистити форму після успішного створення
            setWorker({
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
                pesel: ''
            });
        } catch (error) {
            if (error.response) {
                // Сервер повернув помилку і ми можемо отримати доступ до даних помилки
                const errorMessage = error.response.data.message;
                setError('Failed to create worker. Error: ' + errorMessage);
            } else {
                // Помилка виникла до відправлення запиту або сервер не повернув відповідь
                setError('Failed to create worker due to network error or server is not reachable.');
            }
        }
    };

    return (
        <div>
            <h2>Create Worker</h2>
            {error && <p style={{ color: 'blueviolet' }}>{error}</p>}
            <form onSubmit={handleSubmit}>
                <input type="text" name="name" value={worker.name} onChange={handleChange} placeholder="Name" required />
                <input type="text" name="surname" value={worker.surname} onChange={handleChange} placeholder="Surname" required />
                <input type="email" name="email" value={worker.email} onChange={handleChange} placeholder="Email" required />
                <input type="password" name="password" value={worker.password} onChange={handleChange} placeholder="Password" required />
                <input type="text" name="age" value={worker.age} onChange={handleChange} placeholder="Age" required />
                <input type="text" name="phoneNumber" value={worker.phoneNumber} onChange={handleChange} placeholder="Phone Number" required />
                <input type="text" name="nationality" value={worker.nationality} onChange={handleChange} placeholder="Nationality" required />
                <input type="text" name="city" value={worker.city} onChange={handleChange} placeholder="City" />
                <input type="text" name="street" value={worker.street} onChange={handleChange} placeholder="Street" />
                <input type="text" name="houseNumber" value={worker.houseNumber} onChange={handleChange} placeholder="House Number" />
                <input type="text" name="pesel" value={worker.pesel} onChange={handleChange} placeholder="PESEL" required />
                <button type="submit">Create Worker</button>
            </form>
        </div>
    );
}

export default CreateWorkerForm;