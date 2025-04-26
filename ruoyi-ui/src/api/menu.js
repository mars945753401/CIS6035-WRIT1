import request from '@/utils/request'

// Get routers
export const getRouters = () => {
  return request({
    url: '/getRouters',
    method: 'get'
  })
}