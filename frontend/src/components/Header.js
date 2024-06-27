// src/components/Header.js
import React from 'react';
import { Link } from 'react-router-dom';

const Header = () => {
    return (
        <header>
            <nav>
                <ul>
                    <li><Link to="/createWorker">Create Worker</Link></li>
                    <li><Link to="/createEmployer">Create Employer</Link></li>
                </ul>
            </nav>
        </header>
    );
};

export default Header;