'use strict'
const gulp = require('gulp');
const requireDir = require('require-dir');
requireDir('gulp-tasks');


gulp.paths = {
    dist: 'dist',
};

const paths = gulp.paths;

gulp.task('default', gulp.series('serve'));
