import './App.css'
import {  Navigate, RouterProvider, createBrowserRouter } from 'react-router-dom'
import Applayout from './components/applayout'
import Listtodo from './components/listtodo'
import Addtodo from './components/addtodo'
import { gettodoall } from './service/service'
import Regester from './components/regester'
import Login from './components/login'
import './service/axios'; // This activates the interceptor once for all requests
import { islogin } from './service/authservice'

function App() {
  function Authinticateduser({children}){
    const isauth=islogin();
    if(isauth){
      return children
    }
    else{
      <Navigate to={"/"}/>
    }
  }
const router=createBrowserRouter([
  {
path:"/",
element:<Applayout/>,
children:[
  {
    path:"/",

    element:  <Authinticateduser>
      <Login/>
      </Authinticateduser>
  },
  {path:"/todo",
  element:<Listtodo/>,
 

  },{
    path:"/addtodo",
    element:<Authinticateduser>
      <Addtodo/></Authinticateduser>

  }
  ,{
    path:"/updatetodo/:id",
    element:<Authinticateduser><Addtodo/></Authinticateduser>
  },{
    path:"/regester",
    element:<Regester/>
  },{
    path:"/login",
    element:<Login/>
  }
]
  }
])

  return (
<RouterProvider router={router}/>
   )
}

export default App
