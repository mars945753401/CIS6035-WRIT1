import request from '@/utils/request'

// Search feedbacks
export function listFeedback(query) {
  return request({
    url: '/feedback/list',
    method: 'get',
    params: query
  })
}

// Search feedback by ID
export function getFeedback(feedbackId) {
  return request({
    url: '/feedback/' + feedbackId,
    method: 'get'
  })
}

// Add feedback
export function addFeedback(data) {
  return request({
    url: '/feedback',
    method: 'post',
    data: data
  })
}

// Edit feedback
export function updateFeedback(data) {
  return request({
    url: '/feedback',
    method: 'put',
    data: data
  })
}

// Delete feedback by ID
export function delFeedback(feedbackId) {
  return request({
    url: '/feedback/' + feedbackId,
    method: 'delete'
  })
}
