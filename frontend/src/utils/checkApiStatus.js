import axios from 'axios';
import {BACKEND_URL} from "./routePaths";

const checkApiStatus = async () => {
    return axios.get(`${BACKEND_URL}/health-check`)
        .then(response => {
            return response.status === 200;
        })
        .catch(error => {
            console.log('error checking health status of api: ', error);
            return false;
        })
}

export default checkApiStatus;