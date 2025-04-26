import request from '@/utils/request'

// Search course reservations
export function listCourseReservation(query) {
  return request({
    url: '/reservation/course/list',
    method: 'get',
    params: query
  })
}

// Search course reservation by ID
export function getCourseReservation(courseReservationId) {
  return request({
    url: '/reservation/course/' + courseReservationId,
    method: 'get'
  })
}

// Add course reservation
export function addCourseReservation(data) {
  return request({
    url: '/reservation/course',
    method: 'post',
    data: data
  })
}

// Edit course reservation
export function updateCourseReservation(data) {
  return request({
    url: '/reservation/course',
    method: 'put',
    data: data
  })
}

// Delete course reservation by ID
export function delCourseReservation(courseReservationId) {
  return request({
    url: '/reservation/course/' + courseReservationId,
    method: 'delete'
  })
}
