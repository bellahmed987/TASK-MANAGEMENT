import axios from 'axios';
import { gettoken } from './authservice';

axios.interceptors.request.use(
  function (config) {
    const token = gettoken(); // get from localStorage
    if (token) {
      config.headers['Authorization'] = token;
    }
    return config;
  },
  function (error) {
    return Promise.reject(error);
  }
);
