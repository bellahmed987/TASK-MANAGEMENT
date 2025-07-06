import './App.css'
import {  RouterProvider, createBrowserRouter } from 'react-router-dom'
import Applayout from './components/applayout'
import Listtodo from './components/listtodo'
import Addtodo from './components/addtodo'
import { gettodoall } from './service/service'
import Regester from './components/regester'
import Login from './components/login'
import './service/axios'; // This activates the interceptor once for all requests

function App() {
const router=createBrowserRouter([
  {
path:"/",
element:<Applayout/>,
children:[
  {path:"/",
  element:<Listtodo/>,
 

  },{
    path:"/addtodo",
    element:<Addtodo/>

  }
  ,{
    path:"/updatetodo/:id",
    element:<Addtodo/>
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
