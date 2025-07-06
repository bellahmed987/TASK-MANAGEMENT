import React, { useState } from 'react';
import { loginapicall, storetoken,savelogedinuser } from '../service/authservice';
import { useNavigate } from 'react-router-dom';

function Login() {
  const [usernameoremail, setUsernameOrEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigator = useNavigate();

 async  function handlesubmit(e) {
    e.preventDefault();

    const loginData = { usernameoremail, password };
    console.log("Login payload:", loginData);

  await  loginapicall(usernameoremail, password)
      .then((result) => {
        console.log("Login successful:", result.data);
      
        const token = "Basic " + window.btoa(usernameoremail + ":" + password);
        storetoken(token); 
        savelogedinuser(usernameoremail)
        navigator("/todo");
      })
      .catch((err) => {
        console.log("Login failed:", err.response?.data || err.message);
        alert("Login failed! Please check your credentials.");
      });

    setUsernameOrEmail('');
    setPassword('');
  }

  return (
    <div className="form-container">
      <h2>LOGIN</h2>
      <form onSubmit={handlesubmit}>
        <div className="form-group">
          <label>Email or Username:</label>
          <input
            type="text"
            value={usernameoremail}
            onChange={(e) => setUsernameOrEmail(e.target.value)}
            required
            placeholder="Enter username or email"
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

        <button type="submit">Login</button>
      </form>
    </div>
  );
}

export default Login;
