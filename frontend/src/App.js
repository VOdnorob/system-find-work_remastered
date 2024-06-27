import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import CreateWorker from './pages/CreateWorker';
import CreateEmployer from './pages/CreateEmployer';
import EmployersList from './pages/EmployersList';
import CreateVacancy from './pages/CreateVacancy';
import VacanciesList from './pages/VacanciesList';
import Header from './components/Header';
import Footer from './components/Footer';

function App() {
    return (
        <Router>
            <div className="App">
                <Header />
                <Routes>
                    <Route path="/createWorker" element={<CreateWorker />} />
                    <Route path="/createEmployer" element={<CreateEmployer />} />
                    <Route path="/employers" element={<EmployersList />} />
                    <Route path="/createVacancy" element={<CreateVacancy />} />
                    <Route path="/vacancies" element={<VacanciesList />} />
                    {/* інші маршрути */}
                </Routes>
                <Footer />
            </div>
        </Router>
    );
}

export default App;