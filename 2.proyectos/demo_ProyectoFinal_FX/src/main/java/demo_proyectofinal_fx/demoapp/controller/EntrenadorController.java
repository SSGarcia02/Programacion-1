package demo_proyectofinal_fx.demoapp.controller;

import demo_proyectofinal_fx.demoapp.factory.ModelFactory;
import demo_proyectofinal_fx.demoapp.model.Entrenador;
import demo_proyectofinal_fx.demoapp.utils.ManejadorExcepciones;
import demo_proyectofinal_fx.demoapp.utils.ValidadorDatos;
import demo_proyectofinal_fx.demoapp.exceptions.EntrenadorException;
import demo_proyectofinal_fx.demoapp.exceptions.ClaseException;

import java.util.List;

public class EntrenadorController {

    private final ModelFactory modelFactory;

    public EntrenadorController() {
        this.modelFactory = ModelFactory.getInstancia();
    }

    public List<Entrenador> obtenerEntrenadores() {
        try {
            return modelFactory.obtenerEntrenadores();
        } catch (Exception e) {
            ManejadorExcepciones.manejarExcepcion(e, "obtener lista de entrenadores");
            return List.of();
        }
    }

    public boolean asignarEntrenador(String idEntrenador, String nombreClase) {
        try {
            if (idEntrenador == null || idEntrenador.trim().isEmpty()) {
                throw new EntrenadorException("La identificación del entrenador es obligatoria");
            }

            if (nombreClase == null || nombreClase.trim().isEmpty()) {
                throw new ClaseException("El nombre de la clase es obligatorio");
            }
            Entrenador entrenador = modelFactory.obtenerEntrenador(idEntrenador);
            if (entrenador == null) {
                throw new EntrenadorException("No se encontró un entrenador con la identificación: " + idEntrenador);
            }
            if (entrenador.getClasesAsignadas().contains(nombreClase)) {
                throw new EntrenadorException("El entrenador " + entrenador.getNombre() +
                        " ya tiene asignada la clase: " + nombreClase);
            }

            boolean resultado = modelFactory.asignarEntrenador(idEntrenador, nombreClase);

            if (resultado) {
                ManejadorExcepciones.manejarInformacion("Asignación Exitosa",
                        "El entrenador " + entrenador.getNombre() +
                                " ha sido asignado exitosamente a la clase: " + nombreClase);
            } else {
                throw new EntrenadorException("No se pudo asignar el entrenador a la clase. " +
                        "Verifique que la clase exista y que el entrenador esté disponible.");
            }

            return resultado;

        } catch (EntrenadorException | ClaseException e) {
            ManejadorExcepciones.manejarExcepcion(e, "asignar entrenador a clase");
            return false;
        } catch (Exception e) {
            ManejadorExcepciones.manejarExcepcion(e, "asignar entrenador a clase");
            return false;
        }
    }

    public boolean eliminarEntrenador(String idEntrenador) {
        try {
            if (idEntrenador == null || idEntrenador.trim().isEmpty()) {
                throw new EntrenadorException("La identificación del entrenador es obligatoria");
            }
            Entrenador entrenador = modelFactory.obtenerEntrenador(idEntrenador);
            if (entrenador == null) {
                throw new EntrenadorException("No se encontró un entrenador con la identificación: " + idEntrenador);
            }
            if (!entrenador.getClasesAsignadas().isEmpty()) {
                String clasesAsignadas = String.join(", ", entrenador.getClasesAsignadas());
                boolean confirmar = ManejadorExcepciones.manejarConfirmacion(
                        "Confirmar Eliminación",
                        "El entrenador " + entrenador.getNombre() +
                                " tiene clases asignadas: " + clasesAsignadas +
                                "\n\n¿Está seguro de que desea eliminarlo? Esto removerá todas sus asignaciones."
                );

                if (!confirmar) {
                    ManejadorExcepciones.manejarInformacion("Eliminación Cancelada",
                            "La eliminación del entrenador ha sido cancelada.");
                    return false;
                }
            } else {
                boolean confirmar = ManejadorExcepciones.manejarConfirmacion(
                        "Confirmar Eliminación",
                        "¿Está seguro de que desea eliminar al entrenador " +
                                entrenador.getNombre() + " " + entrenador.getApellido() + "?"
                );

                if (!confirmar) {
                    ManejadorExcepciones.manejarInformacion("Eliminación Cancelada",
                            "La eliminación del entrenador ha sido cancelada.");
                    return false;
                }
            }

            boolean resultado = modelFactory.eliminarEntrenadorFX(idEntrenador);

            if (resultado) {
                ManejadorExcepciones.manejarInformacion("Eliminación Exitosa",
                        "El entrenador ha sido eliminado exitosamente del sistema.");
            } else {
                throw new EntrenadorException("No se pudo eliminar el entrenador. " +
                        "Puede que el entrenador no exista o haya un problema en el sistema.");
            }

            return resultado;

        } catch (EntrenadorException e) {
            ManejadorExcepciones.manejarExcepcion(e, "eliminar entrenador");
            return false;
        } catch (Exception e) {
            ManejadorExcepciones.manejarExcepcion(e, "eliminar entrenador");
            return false;
        }
    }

    public Entrenador registrarEntrenador(String nombre, String apellido, String id, int edad, String telefono) {
        try {
            ValidadorDatos.validarEntrenador(nombre, apellido, id, edad, telefono);
            Entrenador entrenadorExistente = modelFactory.obtenerEntrenador(id);
            if (entrenadorExistente != null) {
                throw new EntrenadorException("Ya existe un entrenador con la identificación: " + id);
            }

            Entrenador nuevoEntrenador = modelFactory.registrarEntrenador(nombre, apellido, id, edad, telefono);

            if (nuevoEntrenador != null) {
                ManejadorExcepciones.manejarInformacion("Registro Exitoso",
                        "El entrenador " + nombre + " " + apellido +
                                " ha sido registrado exitosamente en el sistema.");
            } else {
                throw new EntrenadorException("No se pudo registrar el entrenador. " +
                        "Por favor verifique los datos e intente nuevamente.");
            }

            return nuevoEntrenador;

        } catch (EntrenadorException e) {
            ManejadorExcepciones.manejarExcepcion(e, "registrar entrenador");
            return null;
        } catch (Exception e) {
            ManejadorExcepciones.manejarExcepcion(e, "registrar entrenador");
            return null;
        }
    }

    public boolean actualizarEntrenador(String idActual,
                                        String nombre,
                                        String apellido,
                                        String nuevoId,
                                        int edad,
                                        String telefono) {
        try {
            ValidadorDatos.validarEntrenador(nombre, apellido, nuevoId, edad, telefono);
            Entrenador entrenadorExistente = modelFactory.obtenerEntrenador(idActual);
            if (entrenadorExistente == null) {
                throw new EntrenadorException("No se encontró un entrenador con la identificación: " + idActual);
            }
            if (!idActual.equals(nuevoId)) {
                Entrenador entrenadorConNuevoId = modelFactory.obtenerEntrenador(nuevoId);
                if (entrenadorConNuevoId != null) {
                    throw new EntrenadorException("Ya existe otro entrenador con la nueva identificación: " + nuevoId);
                }
            }

            boolean resultado = modelFactory.actualizarEntrenador(idActual, nombre, apellido, nuevoId, edad, telefono);

            if (resultado) {
                ManejadorExcepciones.manejarInformacion("Actualización Exitosa",
                        "Los datos del entrenador han sido actualizados exitosamente.");
            } else {
                throw new EntrenadorException("No se pudieron actualizar los datos del entrenador. " +
                        "Por favor verifique la información e intente nuevamente.");
            }

            return resultado;

        } catch (EntrenadorException e) {
            ManejadorExcepciones.manejarExcepcion(e, "actualizar entrenador");
            return false;
        } catch (Exception e) {
            ManejadorExcepciones.manejarExcepcion(e, "actualizar entrenador");
            return false;
        }
    }

    public Entrenador obtenerEntrenador(String id) {
        try {
            if (id == null || id.trim().isEmpty()) {
                throw new EntrenadorException("La identificación del entrenador es obligatoria");
            }

            Entrenador entrenador = modelFactory.obtenerEntrenador(id);

            if (entrenador == null) {
                throw new EntrenadorException("No se encontró un entrenador con la identificación: " + id);
            }

            return entrenador;

        } catch (EntrenadorException e) {
            ManejadorExcepciones.manejarExcepcion(e, "obtener entrenador por ID");
            return null;
        } catch (Exception e) {
            ManejadorExcepciones.manejarExcepcion(e, "obtener entrenador por ID");
            return null;
        }
    }
    public boolean eliminarClaseDeEntrenador(String idEntrenador, String nombreClase) {
        try {
            if (idEntrenador == null || idEntrenador.trim().isEmpty()) {
                throw new EntrenadorException("La identificación del entrenador es obligatoria");
            }

            if (nombreClase == null || nombreClase.trim().isEmpty()) {
                throw new ClaseException("El nombre de la clase es obligatorio");
            }
            Entrenador entrenador = modelFactory.obtenerEntrenador(idEntrenador);
            if (entrenador == null) {
                throw new EntrenadorException("No se encontró un entrenador con la identificación: " + idEntrenador);
            }
            if (!entrenador.getClasesAsignadas().contains(nombreClase)) {
                throw new EntrenadorException("El entrenador " + entrenador.getNombre() +
                        " no tiene asignada la clase: " + nombreClase);
            }
            boolean confirmar = ManejadorExcepciones.manejarConfirmacion(
                    "Confirmar Eliminación",
                    "¿Está seguro de que desea eliminar la clase '" + nombreClase +
                            "' del entrenador " + entrenador.getNombre() + " " + entrenador.getApellido() + "?"
            );

            if (!confirmar) {
                ManejadorExcepciones.manejarInformacion("Eliminación Cancelada",
                        "La eliminación de la clase ha sido cancelada.");
                return false;
            }
            entrenador.eliminarClase(nombreClase);

            ManejadorExcepciones.manejarInformacion("Eliminación Exitosa",
                    "La clase '" + nombreClase + "' ha sido eliminada exitosamente del entrenador " +
                            entrenador.getNombre() + ".");

            return true;

        } catch (EntrenadorException | ClaseException e) {
            ManejadorExcepciones.manejarExcepcion(e, "eliminar clase de entrenador");
            return false;
        } catch (Exception e) {
            ManejadorExcepciones.manejarExcepcion(e, "eliminar clase de entrenador");
            return false;
        }
    }
}