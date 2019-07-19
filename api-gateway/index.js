const Redbird = require('redbird')

const proxy = new Redbird({
  port: 8888
})

proxy.register('http://localhost:8888/users', 'http://localhost:3000/users')
proxy.register('http://localhost:8888/transactions', 'http://localhost:3001/transactions')
