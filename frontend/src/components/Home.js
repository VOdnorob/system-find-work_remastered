import React from 'react';
import { useHistory } from 'react-router-dom';

const Home = () => {
    const history = useHistory();

    const handleWorkerClick = () => {
        history.push('/worker-registration');
    };

    const handleEmployerClick = () => {
        history.push('/employer-registration');
    };

    return (
        <div>
            <h1>Register as:</h1>
            <button onClick={handleWorkerClick}>Worker</button>
            <button onClick={handleEmployerClick}>Employer</button>
        </div>
    );
};

export default Home;