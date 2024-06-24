import React, { useState } from 'react';
import axios from 'axios';

const WorkerRegistration = () => {
    const [worker, setWorker] = useState({
        // заповніть властивостями з класу Worker
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setWorker({ ...worker, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/workers', worker)
            .then(response => {
                console.log(response.data);
            })
            .catch(error => {
                console.error(error);
            });
    };

    return (
        <form onSubmit={handleSubmit}>
            <h1>Worker Registration</h1>
            {/* Поля форми для worker */}
            <button type="submit">Register</button>
        </form>
    );
};

export default WorkerRegistration;