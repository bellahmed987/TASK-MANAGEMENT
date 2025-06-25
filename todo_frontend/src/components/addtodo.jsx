import React, { useEffect, useState } from 'react';
import { gettodo, savtodo, updatetodo } from '../service/service';
import { useNavigate, useParams } from 'react-router-dom';

function AddTodo() {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [completed, setCompleted] = useState(false);
  const navigate=useNavigate();
  const {id}=useParams();
  function savetodo(e){
    e.preventDefault();
    const todo={title,description,completed}
    if(id){
      updatetodo(id,todo).then((res)=>{
        navigate('/')
      })
    }
    savtodo(todo).then((res)=>console.log(res.data));
    navigate('/')
    
  }function pagetitle(){
    if(id){
     return <h1>Update Todo</h1>
    }
    else{
      return <h1>Add Todo</h1>
    }
  }
  useEffect(()=>{
if(id){
  gettodo(id).then((response)=>{
    setTitle(response.data.title)
    setDescription(response.data.description)
    setCompleted(response.data.completed)
  })
}
  },[id])

  return (
    <div className="addtodo-container">
      {pagetitle()}
      <form className="addtodo-form">
        <input
          type="text"
          placeholder="Title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
        <input
          type="text"
          placeholder="Description"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
        />
        <select
          value={completed}
          onChange={(e) => setCompleted(e.target.value === 'true')}
        >
          <option value="false">No</option>
          <option value="true">True</option>
        </select>
        <button className="addtodo-btn" onClick={(e)=>savetodo(e)}>Submit</button>
        
      </form>
    </div>
  );
}

export default AddTodo;
