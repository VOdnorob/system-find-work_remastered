import React, { useState } from 'react';
import ApiService from '../services/ApiService';

const CreateVacancy = () => {
    const [vacancy, setVacancy] = useState({
        title: '',
        description: '',
        requirements: '',
        // інші поля вакансії
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setVacancy((prevVacancy) => ({
            ...prevVacancy,
            [name]: value,
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        ApiService.createVacancy(vacancy)
            .then(response => {
                console.log('Vacancy created successfully', response);
                // Обробка успішного створення
            })
            .catch(error => {
                console.error('There was an error creating the vacancy!', error);
            });
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Title:</label>
                <input type="text" name="title" value={vacancy.title} onChange={handleChange} required />
            </div>
            <div>
                <label>Description:</label>
                <textarea name="description" value={vacancy.description} onChange={handleChange} required />
            </div>
            <div>
                <label>Requirements:</label>
                <textarea name="requirements" value={vacancy.requirements} onChange={handleChange} required />
            </div>
            {/* інші поля вакансії */}
            <button type="submit">Create Vacancy</button>
        </form>
    );
};

export default CreateVacancy;