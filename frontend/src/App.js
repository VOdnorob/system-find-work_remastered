import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import CreateWorker from './pages/CreateWorker';
import CreateEmployer from './pages/CreateEmployer';
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
                    {/* інші маршрути */}
                </Routes>
                <Footer />
            </div>
        </Router>
    );
}

export default App;