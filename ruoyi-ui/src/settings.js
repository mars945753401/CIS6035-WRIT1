module.exports = {

  /**
   * Sidebar theme: theme-dark or theme-light
   */
  sideTheme: 'theme-dark',

  /**
   * Is configure system's layout
   */
  showSettings: false,

  /**
   * Is show top navigation
   */
  topNav: false,

  /**
   * Is show tagsView
   */
  tagsView: true,

  /**
   * Is fix header
   */
  fixedHeader: false,

  /**
   * Is show sidebar logo
   */
  sidebarLogo: true,

  /**
   * Is show dynamic title
   */
  dynamicTitle: false,

  /**
   * @type {string | array} 'production' | ['production', 'development']
   * @description Need show err logs component.
   * The default is only used in the production env
   * If you want to also use it in dev, you can pass ['production', 'development']
   */
  errorLog: 'production'
}
