import axios from 'axios';


const API_URL = 'http://localhost:8080/api/user';

class ApiService {
    createWorker(worker) {
        return axios.post(`${API_URL}/createWorker`, worker);
    }

    createEmployer(employer) {
        return axios.post(`${API_URL}/createEmployer`, employer);
    }
}

export default new ApiService();