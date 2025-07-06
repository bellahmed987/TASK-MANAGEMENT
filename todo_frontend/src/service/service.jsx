
const basapi="http://localhost:8080/api/todo";
import axios from "axios"
import { gettoken } from "./authservice";

export const gettodoall=()=>axios.get(basapi)
export const savtodo=(todo)=>axios.post(basapi,todo)
export const gettodo=(id)=>axios.get(basapi+'/'+id)
export const updatetodo=(id, todo)=>axios.put(basapi+'/'+id,todo)
export const deletetodo=(id)=>axios.delete(basapi+'/'+id);
export const completetodo=(id)=>axios.patch(basapi+'/'+id+'/completed')
export const incompletetodo=(id)=>axios.patch(basapi+'/'+id+'/incomplete')

