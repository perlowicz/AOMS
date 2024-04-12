import axios from 'axios';

const checkApiStatus = async () => {
    try {
        const response = await axios.get('http://localhost:8080/api/health-check');
        return response.status === 200;
    } catch (error) {
        return false;
    }
}

export default checkApiStatus;