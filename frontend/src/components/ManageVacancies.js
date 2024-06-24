import React, { useState, useEffect } from 'react';
import axios from 'axios';

const ManageVacancies = () => {
    const [vacancies, setVacancies] = useState([]);
    const [newVacancy, setNewVacancy] = useState({
        // заповніть властивостями з класу Vacancy
    });

    useEffect(() => {
        axios.get('http://localhost:8080/api/vacancies')
            .then(response => {
                setVacancies(response.data);
            })
            .catch(error => {
                console.error(error);
            });
    }, []);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setNewVacancy({ ...newVacancy, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/vacancies', newVacancy)
            .then(response => {
                setVacancies([...vacancies, response.data]);
            })
            .catch(error => {
                console.error(error);
            });
    };

    const handleDelete = (id) => {
        axios.delete(`http://localhost:8080/api/vacancies/${id}`)
            .then(() => {
                setVacancies(vacancies.filter(vacancy => vacancy.id !== id));
            })
            .catch(error => {
                console.error(error);
            });
    };

    return (
        <div>
            <h1>Manage Vacancies</h1>
            <form onSubmit={handleSubmit}>
                {/* Поля форми для newVacancy */}
                <button type="submit">Add Vacancy</button>
            </form>
            <ul>
                {vacancies.map(vacancy => (
                    <li key={vacancy.id}>
                        {vacancy.name} <button onClick={() => handleDelete(vacancy.id)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default ManageVacancies;