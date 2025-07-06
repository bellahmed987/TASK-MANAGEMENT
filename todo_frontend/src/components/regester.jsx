import React, { useState } from 'react';
import { regesterapicall } from '../service/authservice';


function Regester() {
  const [username, setUsername] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const regester={username,email,password}

    console.log(regester)
    regesterapicall(regester).then((result) => {
      console.log(result.data)
    }).catch((err) => {
      console.log(err)
    });
    // Optional: Reset form after submit
    setUsername('');
    setEmail('');
    setPassword('');
  };

  return (
    <div className="form-container">
      <h2>REGISTER</h2>
      <form >
        <div className="form-group">
          <label>Username:</label>
          <input
            type="text"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
            placeholder="Enter username"
          />
        </div>

        <div className="form-group">
          <label>Email:</label>
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
            placeholder="Enter email"
          />
        </div>

        <div className="form-group">
          <label>Password:</label>
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
            placeholder="Enter password"
          />
        </div>

        <button type="submit" onClick={(e)=>handleSubmit(e)}>Register</button>
      </form>
    </div>
  );
}

export default Regester;
