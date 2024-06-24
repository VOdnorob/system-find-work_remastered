import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Home from './components/Home';
import WorkerRegistration from './components/WorkerRegistration';
import EmployerRegistration from './components/EmployerRegistration';
import ManageVacancies from './components/ManageVacancies';
import ViewWorkers from './components/ViewWorkers';

function App() {
    return (
        <Router>
            <Switch>
                <Route path="/" exact component={Home} />
                <Route path="/worker-registration" component={WorkerRegistration} />
                <Route path="/employer-registration" component={EmployerRegistration} />
                <Route path="/manage-vacancies" component={ManageVacancies} />
                <Route path="/view-workers" component={ViewWorkers} />
            </Switch>
        </Router>
    );
}

export default App;