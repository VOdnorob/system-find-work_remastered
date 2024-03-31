import React, { useState, useEffect } from 'react';
import { getAllWorkers } from '../services/workerService';

function WorkersList() {
    const [workers, setWorkers] = useState([]);

    useEffect(() => {
        getAllWorkers().then(response => {
            setWorkers(response.data);
        });
    }, []);

    return (
        <div>
            <h2>Workers List</h2>
            <ul>
                {workers.map(worker => (
                    <li key={worker.id}>{worker.name} {worker.surname} - {worker.email}</li>
                ))}
            </ul>
        </div>
    );
}

export default WorkersList;