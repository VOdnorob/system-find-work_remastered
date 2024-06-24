import React, { useState, useEffect } from 'react';
import axios from 'axios';

const ViewWorkers = () => {
    const [workers, setWorkers] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/workers')
            .then(response => {
                setWorkers(response.data);
            })
            .catch(error => {
                console.error(error);
            });
    }, []);

    return (
        <div>
            <h1>View Workers</h1>
            <ul>
                {workers.map(worker => (
                    <li key={worker.id}>
                        {worker.name} - {worker.position}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default ViewWorkers;