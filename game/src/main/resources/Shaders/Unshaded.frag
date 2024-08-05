#import "Common/ShaderLib/GLSLCompat.glsllib"

varying vec3 normal;

uniform vec4 u_DiffuseColor;

void main(){
    gl_FragColor = u_DiffuseColor * vec4((normal * vec3(0.5)) + vec3(0.5), 1.0);
}
