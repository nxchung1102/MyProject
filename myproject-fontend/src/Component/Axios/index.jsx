import axios from 'axios';
const instance = axios.create({
  baseURL: 'https://fakestoreapi.com',
});
instance.interceptors.response.use(
  (res) => res.data,
  (error) => {
    return Promise.reject(error);
  },
);
export default instance;
