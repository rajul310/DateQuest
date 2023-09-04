import axios from 'axios';

const BASE_URL = 'http://localhost:8080';

/* POST request URLs*/
const LOGIN_API_URL = `${BASE_URL}/users/login`;

class ApiService { 
    login(data) {
        return axios.post(LOGIN_API_URL, data);
    }

}

export default new ApiService();