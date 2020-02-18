import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Signup from '@/components/Signup'
import Manager from '@/components/Manager'
import managerHome from '@/components/managerHome'
import managerAssign from '@/components/managerAssign'
import managerInfo from '@/components/managerInfo'
import managerHome2 from '@/components/managerHome2'
import tutor from '@/components/tutor'
import MaxMin from '@/components/MaxMin'



Vue.use(Router)

export default new Router({
   routes: [
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/signup',
      name: 'signup',
      component: Signup
    },
    {
      path: '/manager',
      name: 'manager',
      component: Manager,
	children: [
	  {
     	    path: '/manager/home',
            name: 'managerHome',
            component: managerHome,
	  },
    {
     	    path: '/manager/tutor',
            name: 'tutor',
            component: tutor,
	  },
    {
          path: '/manager/MaxMin',
            name: 'MaxMin',
            component: MaxMin,
    },
	  {
	    path: '/manager/assignroom',
            name: 'managerAssign',
            component: managerAssign,
	  },
	  {
	    path: '/manager/viewinfo',
            name: 'managerInfo',
            component: managerInfo,
	  },
      {
        path: '/manager/home2',
        name: 'managerHome2',
        component: managerHome2,
      }
	]
    }
   ]
})
