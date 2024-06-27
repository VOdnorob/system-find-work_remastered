import React, { useEffect, useState } from 'react';
import ApiService from '../services/ApiService';

const VacanciesList = () => {
    const [vacancies, setVacancies] = useState([]);

    useEffect(() => {
        ApiService.getAllVacancies()
            .then(response => {
                setVacancies(response.data);
            })
            .catch(error => {
                console.error('There was an error fetching the vacancies!', error);
            });
    }, []);

    return (
        <div>
            <h1>Vacancies List</h1>
            <ul>
                {vacancies.map((vacancy, index) => (
                    <li key={index}>
                        <h2>{vacancy.title}</h2>
                        <p>{vacancy.description}</p>
                        <p>{vacancy.requirements}</p>
                        {/* інші поля вакансії */}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default VacanciesList;