import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})


function UserDto (name, password) {
  this.username = name
  this.password = password
  this.company = "WeissCo."
}

export default {
	name: 'login',
	data () {
		return {
			users: [],
			newUser: '',
			newPassword: '',
			errorPassword: '',
			errorUser: '',
			response: []
		}
	},
	created: function () {
	  // Initializing people from backend
	    AXIOS.get(`/users`)
	    .then(response => {
	      // JSON responses are automatically parsed.
	      this.users = response.data
	    })
	    .catch(e => {
	      this.errorUser = e.message
	      console.log(e.message)
	    });
	},
	methods: {
		createUser: function (username, password) {
			  AXIOS.post(`/users/`, {username_name: username,password: password})
			  .then(response => {
			    // JSON responses are automatically parsed.
			    this.users.push(response.data)
			    this.newUser = ''
			    this.errorUser = ''
			    this.newPassword = ''
			  })
			  .catch(e => {
			    var errorMsg = e.message
			    console.log(errorMsg)
			    this.errorUser = errorMsg
			  });
		}
	}
}