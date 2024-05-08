import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/workers'; // Змініть на URL вашого бекенду

export const createWorker = async (workerData) => {
    return axios.post(`${API_BASE_URL}/createWorker`, workerData);
};

export const getAllWorkers = async () => {
    return axios.get(`${API_BASE_URL}/findWorker`);
};