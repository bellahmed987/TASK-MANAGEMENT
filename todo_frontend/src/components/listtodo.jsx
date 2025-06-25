import React, { useEffect, useState } from 'react'
import { useLoaderData, useNavigate, useParams } from 'react-router-dom'
import { completetodo, deletetodo, incompletetodo } from '../service/service';


function listtodo() {
  const response=useLoaderData();
  const gettodoall=response.data
  const [todo,setodo]=useState([]);
  const navigate=useNavigate();
 
  useEffect(()=>{
setodo(gettodoall)
  },[gettodoall])
  function addtodo(){
navigate('/addtodo')
  }
  function updatetodo(id){
navigate(`/updatetodo/${id}`)
window.location.reload()
  }
  function deltodo(id){
    deletetodo(id).then((res)=>{
      console.log("delete done")
      window.location.reload()
    })
  }function comtodo(id){
 completetodo(id)
 window.location.reload()
 listtodo()
  
  }
  function incomtodo(id){
    incompletetodo(id)
    window.location.reload()
  }
  
  return (
    <div className="container">
    <h1>Todo List</h1>
    <button className="addtodo" onClick={addtodo}>ADD todo</button>
    <table className="todo-table">
      <thead>
        <tr>
          <th>Title</th>
          <th>Description</th>
          <th>Completed</th>
          <th>Actios</th>
        </tr>
      </thead>
      <tbody>    {todo.map((todo) => (
            <tr key={todo.id}>
              <td>{todo.title}</td>
              <td>{todo.description}</td>
              <td>{todo.completed ? "Yes" : "No"}</td>
            <div className='opbtn'>  <button className="updatetodo" onClick={()=>updatetodo(todo.id)}>UPDATE</button>
              <button className="deletetodo" onClick={()=>deltodo(todo.id)}>DELETE</button>
              <button className="comtodo" onClick={()=>comtodo(todo.id)}>Complete</button>
              <button className="comtodo" onClick={()=>incomtodo(todo.id)}>INComplete</button>
              </div> </tr>
          ))}
        
      </tbody>
    </table>
  </div>
    
  )
}

export default listtodo