import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080'; // Зміни на URL твого бекенду

export const fetchData = async () => {
    try {
        const response = await axios.get(`${API_BASE_URL}/your-endpoint`);
        return response.data;
    } catch (error) {
        console.error("There was an error fetching the data", error);
    }
};