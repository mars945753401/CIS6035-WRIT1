import request from '@/utils/request'

// Search courses
export function listCourse(query) {
  return request({
    url: '/resource/course/list',
    method: 'get',
    params: query
  })
}

// Search courses (without pagination)
export function listCourseWithoutPagination(query) {
  return request({
    url: '/resource/course/listCourseWithoutPagination',
    method: 'get',
    params: query
  })
}

// Search course by ID
export function getCourse(courseId) {
  return request({
    url: '/resource/course/' + courseId,
    method: 'get'
  })
}

// Add course
export function addCourse(data) {
  return request({
    url: '/resource/course',
    method: 'post',
    data: data
  })
}

// Edit course
export function updateCourse(data) {
  return request({
    url: '/resource/course',
    method: 'put',
    data: data
  })
}

// Delete course by ID
export function delCourse(courseId) {
  return request({
    url: '/resource/course/' + courseId,
    method: 'delete'
  })
}
