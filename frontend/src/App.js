import React from 'react';
import WorkersList from './components/WorkersList';
import CreateWorkerForm from './components/CreateWorkerForm';
import './App.css';

function App() {
    return (
        <div className="App">
            <CreateWorkerForm />
            <WorkersList />
        </div>
    );
}

export default App;