import React from 'react'
import axios from 'axios';
const authbaseapi="http://localhost:8080/api/auth"
export const regesterapicall=(regesterobj)=>axios.post(authbaseapi +'/regester',regesterobj);
export const loginapicall=(usernameoremail,password)=>axios.post(authbaseapi+ "/login",{usernameoremail,password})
export const storetoken=(token)=>localStorage.setItem("token",token)
export const gettoken= ()=>localStorage.getItem("token")