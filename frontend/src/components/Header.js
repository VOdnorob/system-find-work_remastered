import React from 'react';
import { Link } from 'react-router-dom';

const Header = () => {
    return (
        <header>
            <nav>
                <ul>
                    <li><Link to="/createWorker">Create Worker</Link></li>
                    <li><Link to="/createEmployer">Create Employer</Link></li>
                    <li><Link to="/employers">View Employers</Link></li>
                    <li><Link to="/createVacancy">Create Vacancy</Link></li>
                    <li><Link to="/vacancies">View Vacancies</Link></li>
                </ul>
            </nav>
        </header>
    );
};

export default Header;