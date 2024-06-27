import React, { useEffect, useState } from 'react';
import ApiService from '../services/ApiService';

const EmployersList = () => {
    const [employers, setEmployers] = useState([]);

    useEffect(() => {
        ApiService.getAllEmployers()
            .then(response => {
                setEmployers(response.data);
            })
            .catch(error => {
                console.error('There was an error fetching the employers!', error);
            });
    }, []);

    return (
        <div>
            <h1>Employers List</h1>
            <ul>
                {employers.map((employer, index) => (
                    <li key={index}>
                        {employer.name} {employer.surname} - {employer.email} - {employer.phone} - {employer.nameOfCompany}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default EmployersList;