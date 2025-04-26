import request from '@/utils/request'

// Login
export function login(username, password, code, uuid) {
  const data = {
    username,
    password,
    code,
    uuid
  }
  return request({
    url: '/login',
    headers: {
      isToken: false,
      repeatSubmit: false
    },
    method: 'post',
    data: data
  })
}

// Register
export function register(data) {
  return request({
    url: '/register',
    headers: {
      isToken: false
    },
    method: 'post',
    data: data
  })
}

// Get user's info
export function getInfo() {
  return request({
    url: '/getInfo',
    method: 'get'
  })
}

// Logout
export function logout() {
  return request({
    url: '/logout',
    method: 'post'
  })
}

// Get captcha image
export function getCodeImg() {
  return request({
    url: '/captchaImage',
    headers: {
      isToken: false
    },
    method: 'get',
    timeout: 20000
  })
}