"use strict";
const gulp = require("gulp");
const injectPartials = require("gulp-inject-partials");
const inject = require("gulp-inject");
const rename = require("gulp-rename");
const prettify = require("gulp-prettify");
const replace = require("gulp-replace");
const merge = require("merge-stream");

/* inject partials like sidebar and navbar */
gulp.task("injectPartial", function () {
  return gulp
    .src(["./*/pages/*/*.html", "./*/index.html"], {
      base: "./",
    })
    .pipe(injectPartials())
    .pipe(gulp.dest("."));
});

/* inject Js and CCS assets into HTML */
gulp.task("injectAssets", function () {
  return gulp
    .src(["./**/*.html"])
    .pipe(
      inject(
        gulp.src(
          [
            './src/assets/vendors/iconfonts/mdi/css/materialdesignicons.min.css',
             './src/assets/vendors/iconfonts/ionicons/dist/css/ionicons.css',
            // './src/assets/vendors/iconfonts/typicons/src/font/typicons.css',
            './src/assets/vendors/iconfonts/flag-icon-css/css/flag-icon.min.css',
            './src/assets/vendors/css/vendor.bundle.base.css',
            './src/assets/vendors/css/vendor.bundle.addons.css',
            './src/assets/vendors/js/vendor.bundle.base.js',
            './src/assets/vendors/js/vendor.bundle.addons.js'
          ],
          {
            read: false,
          }
        ),
        {
          name: "plugins",
          relative: true,
        }
      )
    )
    .pipe(
      inject(
        gulp.src(
          [
            '!css/horizontal-layouts.css',
            '!css/horizontal-layouts-2.css',
            '!css/sidebar-layouts.css',
            'src/assets/css/*.css',
            'src/assets/js/shared/off-canvas.js',
            // 'src/assets/js/shared/hoverable-collapse.js',
            'src/assets/js/shared/misc.js',
          ],
          {
            read: false,
          }
        ),
        {
          relative: true,
        }
      )
    )
    .pipe(gulp.dest("."));
});

/*replace image path and linking after injection*/
gulp.task("replacePath", function () {
  const replacePath1 = gulp
    .src("./*/pages/**/*.html", {
      base: "./",
    })
    .pipe(replace('src="assets/images/', 'src="../../assets/images/'))
    .pipe(replace('href="pages/', 'href="../../pages/'))
    .pipe(
      replace(
        'href="documentation"',
        'href="http://www.bootstrapdash.com/demo/plus/jquery/documentation/documentation.html"'
      )
    )
    .pipe(replace('href="index.html"', 'href="../../index.html"'))
    .pipe(gulp.dest("."));
  const replacePath2 = gulp
    .src("./*/index.html", {
      base: "./",
    })
    .pipe(replace('src="assets/images/', 'src="assets/images/'))
    .pipe(
      replace(
        'href="documentation',
        'href="http://www.bootstrapdash.com/demo/plus/jquery/documentation/documentation.html"'
      )
    )
    .pipe(gulp.dest("."));
  return merge(replacePath1, replacePath2);
});

gulp.task("html-beautify", function () {
  return gulp
    .src(["./**/*.html", "!node_modules/**/*.html"])
    .pipe(
      prettify({
        unformatted: ["pre", "code", "textarea"],
      })
    )
    .pipe(
      gulp.dest(function (file) {
        return file.base;
      })
    );
});

/*sequence for injecting partials and replacing paths*/
gulp.task(
  "inject",
  gulp.series("injectPartial", "injectAssets", "html-beautify", "replacePath")
);
