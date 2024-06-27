import axios from 'axios';

const API_URL = 'http://localhost:8080/api/user';
const EMPLOYER_API_URL = 'http://localhost:8080/api/employers';

class ApiService {
    createWorker(worker) {
        return axios.post(`${API_URL}/createWorker`, worker);
    }

    createEmployer(employer) {
        return axios.post(`${API_URL}/createEmployer`, employer);
    }

    getAllWorkers() {
        return axios.get(`${API_URL}/workers`);
    }

    getAllEmployers() {
        return axios.get(`${API_URL}/employers`);
    }

    createVacancy(vacancy) {
        return axios.post(`${EMPLOYER_API_URL}/vacancy`, vacancy);
    }

    getAllVacancies() {
        return axios.get(`${EMPLOYER_API_URL}/vacancy`);
    }
}

export default new ApiService();