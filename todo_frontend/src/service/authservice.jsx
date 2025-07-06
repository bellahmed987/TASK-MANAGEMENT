import axios from 'axios';

const authbaseapi = "http://localhost:8080/api/auth";

export const regesterapicall = (regesterobj) =>
  axios.post(authbaseapi + '/regester', regesterobj);

export const loginapicall = (usernameoremail, password) =>
  axios.post(authbaseapi + "/login", { usernameoremail, password });

export const storetoken = (token) =>
  localStorage.setItem("token", token);

export const gettoken = () =>
  localStorage.getItem("token");

export const savelogedinuser = (username) =>
  sessionStorage.setItem("authenticateduser", username);

export const islogin = () => {
  const username = sessionStorage.getItem("authenticateduser");
  return username !== null;
}

export const getlogedinuser = () => {
  return sessionStorage.getItem("authenticateduser");
}

export const logout = () => {
  localStorage.clear();
  sessionStorage.clear();
 
}
